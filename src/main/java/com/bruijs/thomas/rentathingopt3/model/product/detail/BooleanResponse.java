package com.bruijs.thomas.rentathingopt3.model.product.detail;

import java.util.ArrayList;

public class BooleanResponse {
    public final static BooleanResponse TRUE_FALSE = new BooleanResponse("true", "false");
    public final static BooleanResponse JA_NEE = new BooleanResponse("ja", "nee");
    public final static BooleanResponse WEL_NIET = new BooleanResponse("wel", "niet");
    public final static BooleanResponse JUIST_ONJUIST = new BooleanResponse("juist", "onjuist");
    public static ArrayList<BooleanResponse> responses = setResponses();

    final String RESPONSE_TRUE, RESPONSE_FALSE;

    public BooleanResponse(String responseTrue, String responseFalse) {
        RESPONSE_TRUE = responseTrue;
        RESPONSE_FALSE = responseFalse;
    }

    public String getResponse(boolean value) {
        return value ? getResponseTrue() : getResponseFalse();
    }

    public String getResponseTrue() {
        return RESPONSE_TRUE;
    }

    public String getResponseFalse() {
        return RESPONSE_FALSE;
    }

    public static Boolean getResponseValueByString(String string) {
        for (BooleanResponse response : responses) {
            if (response.getResponseTrue().equalsIgnoreCase(string)) return true;
            if (response.getResponseFalse().equalsIgnoreCase(string)) return false;
        }
        return null;
    }

    private static ArrayList<BooleanResponse> setResponses() {
        ArrayList<BooleanResponse> responses = new ArrayList<>();
        responses.add(TRUE_FALSE);
        responses.add(JA_NEE);
        responses.add(WEL_NIET);
        responses.add(JUIST_ONJUIST);
        return responses;
    }
}
