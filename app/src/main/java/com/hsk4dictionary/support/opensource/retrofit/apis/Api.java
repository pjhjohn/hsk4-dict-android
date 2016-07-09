package com.hsk4dictionary.support.opensource.retrofit.apis;

/**
 * Created by pjhjohn on 2015-10-31.
 */
public class Api {
    /* Singleton */
    private static Api instance = null;
    public static Api getInstance() {
        return instance;
    }

    /* Instance Creation */
    private Api(HSK4Dictionary HSK4DictionaryApi) {
        this.HSK4DictionaryApi = HSK4DictionaryApi;
    }

    /**
     * Only triggered when first triggered.
     * @param HSK4DictionaryApi
     */
    public static synchronized void createInstance(HSK4Dictionary HSK4DictionaryApi) {
        if(Api.instance != null) return;
        Api.instance = new Api(HSK4DictionaryApi);
    }

    /* Register Papyruth Api*/
    private final HSK4Dictionary HSK4DictionaryApi;
    public static HSK4Dictionary playting() {
        return Api.instance.HSK4DictionaryApi;
    }
}
