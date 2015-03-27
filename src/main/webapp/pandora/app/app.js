Ext.application({
    name: 'Pandora',
    
    autoCreateViewport: true,
    paths: {
    	'Pandora':'pandora/app'   
    },
    models: ['Station', 'Song'],    
    stores: ['Stations', 'RecentSongs', 'SearchResults'],
    controllers: ['Station', 'Song']
});