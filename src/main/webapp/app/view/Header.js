/**
 * The application header displayed at the top of the viewport
 * @extends Ext.Component
 */
Ext.define('Books.view.Header', {
    extend: 'Ext.Component',
    
    dock: 'top',
    baseCls: 'app-header',
    
    initComponent: function() {
        Ext.applyIf(this, {
            html: 'this is a demo test'
        });
                
        this.callParent(arguments);
    }
});