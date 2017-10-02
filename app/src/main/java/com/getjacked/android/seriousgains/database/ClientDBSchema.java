package com.getjacked.android.seriousgains.database;

/**
 * :(
 */

public class ClientDBSchema {
    public static final class ClientTable {
        public static final String NAME = "clients";
        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String FIRSTNAME = "firstname";
            public static final String LASTNAME = "lastname";
            public static final String PRONOUNS = "pronouns";
            public static final String WEIGHT = "weight";
            public static final String HEIGHT = "height";
            public static final String STREETADDRESS = "streetaddress";
            public static final String CITY = "city";
            public static final String STATE = "state";
            public static final String ZIPCODE = "zipcode";
            public static final String CREDITCARDNUMBER = "creditcardnumber";
            public static final String CREDITCARDTYPE = "creditcardtype";
            public static final String CVC = "cvc";
        }
    }
}
