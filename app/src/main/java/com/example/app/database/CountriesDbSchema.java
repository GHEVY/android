package com.example.app.database;

public class CountriesDbSchema {
    public static final class CountriesTable {
        public static final String NAME = "countries";
        public static final class Cols {
            public static final String continent = "continent";
            public static final String name = "name";
            public static final String isfav = "favorite";
        }

    }
}