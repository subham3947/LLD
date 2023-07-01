package com.example.geektrust.constants;

import java.util.HashMap;
import java.util.Map;

public class Month {
    static final int JANUARY_INDEX = 1, FEBRUARY_INDEX = 2,MARCH_INDEX = 3,APRIL_INDEX = 4,
                    MAY_INDEX = 5,JUNE_INDEX = 6,JULY_INDEX = 7,AUGUST_INDEX = 8,
                    SEPTEMBER_INDEX = 9,OCTOBER_INDEX = 10,NOVEMBER_INDEX = 11,DECEMBER_INDEX = 12;
    public static final Map<String, Integer> monthMap = new HashMap<String, Integer>() {{
        put("JANUARY",JANUARY_INDEX);put("FEBRUARY",FEBRUARY_INDEX);put("MARCH",MARCH_INDEX);put("APRIL",APRIL_INDEX);
        put("MAY",MAY_INDEX);put("JUNE",JUNE_INDEX);put("JULY",JULY_INDEX);put("AUGUST",AUGUST_INDEX);
        put("SEPTEMBER",SEPTEMBER_INDEX);put("OCTOBER",OCTOBER_INDEX);put("NOVEMBER",NOVEMBER_INDEX);put("DECEMBER",DECEMBER_INDEX);
    }};
}
