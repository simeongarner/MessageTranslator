package com.example.nuntius;


import android.support.v7.app.AppCompatActivity;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.util.Language;
import com.ibm.watson.personality_insights.v3.model.ContentItem;

public class Translator extends AppCompatActivity {

    Authenticator authenticator = new IamAuthenticator("ZLs7mIlKcjUIMD8JNd1UvoGA88RYmwqttfxduixL9dnj");

    Translator(){
    }

    public String Translate(String toBeTranslated){

        String translatedString = "";

        try {
            LanguageTranslator services = new LanguageTranslator("2018-05-01", authenticator);

//            LanguageTranslator languageTranslator = new LanguageTranslator("2018-05-01", authenticator);
            services.setServiceUrl("https://gateway.watsonplatform.net/language-translator/ZLs7mIlKcjUIMD8JNd1UvoGA88RYmwqttfxduixL9dnj");


            TranslateOptions translateOptions = new TranslateOptions.Builder().addText(toBeTranslated).source(Language.ENGLISH).target(Language.SPANISH).build();

            translatedString = services.translate(translateOptions).execute().getResult().toString();
        }
        catch (Exception e){

        }
        return translatedString;
    }
}
