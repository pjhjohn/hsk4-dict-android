package com.hsk4dictionary.support.opensource.retrofit.apis;

import com.hsk4dictionary.android.model.Card;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by pjhjohn on 2015-10-28.
 */
public interface HSK4Dictionary {
    @GET("cards/read/{id}")
    Observable<Card> get_card(
        @Path("id") Integer id
    );
}
