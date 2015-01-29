package droidsafe.eclipse.plugin.core.view.indicator;

import java.util.Map;
import java.util.Set;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.actions.CompoundContributionItem;

/**
 * A dynamic menu for label display options. The menu is of form
 * 
 *   Use Long Label
 *   Show <field name>
 *   ...
 *   Show <field name>
 * 
 * @author gilham
 *
 */
public class DynamicLabelDisplayMenu extends CompoundContributionItem {

    /* (non-Javadoc)
     * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
     */
    protected IContributionItem[] getContributionItems() {
        final IndicatorViewPart view = Utils.getIndicatorView();
        if (view == null)
            return new IContributionItem[0];

        Map<String, Boolean> displayMap = view.getLabelDisplayMap();

        Set<String> fields = displayMap.keySet();
        IContributionItem[] items = new IContributionItem[fields.isEmpty() ? 1 : fields.size() + 2];
        items[0] = new ContributionItem() {

        	/* (non-Javadoc)
        	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu, int)
        	 */
            public void fill(Menu menu, int index) {
                MenuItem item = new MenuItem(menu, SWT.CHECK);
                item.setText("Use Long Label");
                item.addListener(SWT.Selection, getMenuItemListener(view));
                item.setSelection(view.longLabel());
            }

            /**
             * Returns the menu item listener for "Use Long Label".
             * 
             * @param view - the indicator outline view
             * @return the listener
             */
            private Listener getMenuItemListener(final IndicatorViewPart view) {
                return new Listener() {

                	/* (non-Javadoc)
                	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
                	 */
                    public void handleEvent(Event event) {
                        if (view != null) {
                            view.setLongLabel(!view.longLabel());
                            view.updateLabels();
                        }
                    }
                };
            }
        };
        if (!fields.isEmpty()) {
            items[1] = new Separator();
            int i = 2;
            for (final String field: fields) {
                items[i++] = new ContributionItem() {

                	/* (non-Javadoc)
                	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu, int)
                	 */
                    public void fill(Menu menu, int index) {
                        MenuItem item = new MenuItem(menu, SWT.CHECK);
                        item.setText("Show "+field);
                        item.addListener(SWT.Selection, getMenuItemListener(field, view));
                        item.setSelection(view.getLabelDisplay(field));
                    }

                    /**
                     * Returns the menu item listener for checking/unchecking a "Show <field>"
                     * item..
                     * 
                     * @param field - the field
                     * @param view - the indicator outline view
                     * @return the listener
                     */
                    private Listener getMenuItemListener(final String field,
                                                         final IndicatorViewPart view) {
                        return new Listener() {

                        	@Override
                            public void handleEvent(Event event) {
                                if (view != null) {
                                    view.toggleLabelDisplay(field);
                                    view.updateLabels();
                                }
                            }
                        };
                    }
                };
            }
        }

        return items;

    }

}
