package droidsafe.eclipse.plugin.core.commands;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.SourceType;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.gson.JsonElement;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.callhierarchy.CallHierarchy;
import droidsafe.eclipse.plugin.core.view.callhierarchy.CallHierarchyViewPart;
import droidsafe.eclipse.plugin.core.view.callhierarchy.CalleeHierarchy;
import droidsafe.eclipse.plugin.core.view.callhierarchy.CallerHierarchy;
import droidsafe.eclipse.plugin.core.view.callhierarchy.SourceMethodNode;

/**
 * Command to show the source callee/caller hierarchy for the current selection in the Java editor window.
 * Recursion is not supported in the call hierarchy display.
 * 
 * @author gilham
 *
 */
public class ShowCallHierarchy extends AbstractHandler {

	/**
	 * Command implementation. When the current selection in the Java editor is a method call, displays
	 * in an outline window the callee hierarchy rooted at the targets of the method call.  When the
	 * current selection is a method declaration, displays the caller hierarchy rooted at the callers
	 * of the method.
	 */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
        IWorkbenchPage activePage = window.getActivePage();
        ISelection selection = HandlerUtil.getActiveSite(event).getSelectionProvider().getSelection();
        if (selection instanceof TextSelection) {
        	TextSelection textSelection = (TextSelection) selection;
        	IEditorPart editor = activePage.getActiveEditor();
        	IProject project = DroidsafePluginUtilities.getProcessedDroidsafeProjectForEditor(editor);
        	if (project != null) {
        		JsonElement projectCallHierarchy = CallHierarchy.getProjectCalleeHierarchy(project);
        		if (projectCallHierarchy != null) {
        			ITypeRoot typeRoot = JavaUI.getEditorInputTypeRoot(editor.getEditorInput());
        			try {
        				IJavaElement[] elements = typeRoot.codeSelect(textSelection.getOffset(), textSelection.getLength());
        				if (elements != null && elements.length == 1 && elements[0] instanceof IMethod) {
        					// current selection is a method call
        					IMethod method = (IMethod) elements[0];
        					int line = textSelection.getStartLine() + 1;
        					String className = getEnclosingClassName(method);
        					String pkgName = typeRoot.getParent().getElementName();
        					String srcClassName = pkgName + "." + typeRoot.getElementName().replace(".java", "");
        					IJavaElement parent = method.getParent();
        					boolean showCallees = method.isResolved() && !(parent instanceof SourceType);
        					if (showCallees) {
        						Collection<JsonElement> targets = CalleeHierarchy.findCallTargets(projectCallHierarchy, method, className, srcClassName, line);
        						if (targets.isEmpty())
        							CallHierarchyViewPart.openView(null);
        						else {
        							CalleeHierarchy cg = new CalleeHierarchy(project, targets, method);
        							CallHierarchyViewPart.openView(cg);
        						}
        					} else {
        						// current selection is a method declaration
        						Map<String, Map<String, Set<JsonElement>>> callerMap = CallerHierarchy.getCallerMap(project);
        						if (callerMap != null && !callerMap.isEmpty()) {
        							SourceMethodNode methodNode = CallerHierarchy.findSourceMethodNodeWithCallers(callerMap, method, className, srcClassName, line);
        							if (methodNode == null)
        								CallHierarchyViewPart.openView(null);
        							else {
        								CallerHierarchy cg = new CallerHierarchy(project, methodNode, method);
        								CallHierarchyViewPart.openView(cg);
        							}
        						}
        					}
        				}
        			} catch (JavaModelException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}
        	}
        }
        return null;
    }
    
    /**
     * Returns the enclosing class name for the given Java element in the Java editor.
     * 
     * @param e - a Java element in the Jave editor
     * @return the enclosing class name
     */
    private String getEnclosingClassName(IJavaElement e) {
    	String name = null;
    	String parentName = null;
    	if (e instanceof IType || e instanceof IPackageFragment) {
    		name = e.getElementName();
		}
    	IJavaElement parent = e.getParent();
    	if (parent != null) {
    		parentName = getEnclosingClassName(parent);
    	}
    	if (name == null)
    		return parentName;
    	if (parentName == null)
    		return name;
    	String sep = (parent instanceof ICompilationUnit || parent instanceof IClassFile) ? "." : "$";
    	return parentName + sep + name;
	}

}
