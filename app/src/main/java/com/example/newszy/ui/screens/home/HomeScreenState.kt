package com.example.newszy.ui.screens.home

import com.example.newszy.domain.model.Article

data class HomeScreenState(
    val headlineArticle : List<Article>  = emptyList(),
    val mainNewsArticle : List<Article>  = emptyList(),
    val countryList : List<String> = getListOfCountry(),
    val headlineCountry : String = "",
    val mainNewsCountry : String = "",
    val category : List<String> = getListOfCategory(),
    val selectedCategory : String = ""

){
    companion object{
        fun getListOfCountry() : List<String>{
            return listOf(
                "United Arab Emirates",
                "Argentina",
                "Austria",
                "Australia",
                "Belgium",
                "Bulgaria",
                "Brazil",
                "Canada",
                "Switzerland",
                "China",
                "Colombia",
                "Cuba",
                "Czech Republic",
                "Germany",
                "Egypt",
                "France",
                "United Kingdom",
                "Greece",
                "Hong Kong",
                "Hungary",
                "Indonesia",
                "Ireland",
                "Israel",
                "India",
                "Italy",
                "Japan",
                "South Korea",
                "Lithuania",
                "Latvia",
                "Morocco",
                "Mexico",
                "Malaysia",
                "Nigeria",
                "Netherlands",
                "Norway",
                "New Zealand",
                "Philippines",
                "Poland",
                "Portugal",
                "Romania",
                "Serbia",
                "Russia",
                "Saudi Arabia",
                "Sweden",
                "Singapore",
                "Slovenia",
                "Slovakia",
                "Thailand",
                "Turkey",
                "Taiwan",
                "Ukraine",
                "United States",
                "Venezuela",
                "South Africa"
            )
        }

        fun getCountry(value: String) : Country?{
            val map = Country.entries.associateBy( Country::value)
            return map[value]
        }

        fun getListOfCategory(): List<String> {
            return listOf(
                "BUSINESS",
                "ENTERTAINMENT",
                "GENERAL",
                "HEALTH",
                "SCIENCE",
                "SPORTS",
                "TECHNOLOGY"
            )
        }

    }
}

enum class Country(val value: String) {
    AE("United Arab Emirates"),
    AR("Argentina"),
    AT("Austria"),
    AU("Australia"),
    BE("Belgium"),
    BG("Bulgaria"),
    BR("Brazil"),
    CA("Canada"),
    CH("Switzerland"),
    CN("China"),
    CO("Colombia"),
    CU("Cuba"),
    CZ("Czech Republic"),
    DE("Germany"),
    EG("Egypt"),
    FR("France"),
    GB("United Kingdom"),
    GR("Greece"),
    HK("Hong Kong"),
    HU("Hungary"),
    ID("Indonesia"),
    IE("Ireland"),
    IL("Israel"),
    IN("India"),
    IT("Italy"),
    JP("Japan"),
    KR("South Korea"),
    LT("Lithuania"),
    LV("Latvia"),
    MA("Morocco"),
    MX("Mexico"),
    MY("Malaysia"),
    NG("Nigeria"),
    NL("Netherlands"),
    NO("Norway"),
    NZ("New Zealand"),
    PH("Philippines"),
    PL("Poland"),
    PT("Portugal"),
    RO("Romania"),
    RS("Serbia"),
    RU("Russia"),
    SA("Saudi Arabia"),
    SE("Sweden"),
    SG("Singapore"),
    SI("Slovenia"),
    SK("Slovakia"),
    TH("Thailand"),
    TR("Turkey"),
    TW("Taiwan"),
    UA("Ukraine"),
    US("United States"),
    VE("Venezuela"),
    ZA("South Africa")
}

enum class Category(val value: String){
    BUSINESS("BUSINESS"),
    ENTERTAINMENT("ENTERTAINMENT"),
    GENERAL("GENERAL"),
    HEALTH("HEALTH"),
    SCIENCE("SCIENCE"),
    SPORTS("SPORTS"),
    TECHNOLOGY("TECHNOLOGY")
}
