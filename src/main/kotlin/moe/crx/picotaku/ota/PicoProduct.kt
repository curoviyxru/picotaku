package moe.crx.picotaku.ota

enum class PicoProduct(
    val productName: String,
    val secretKey: String,
    val model: String,
    val endpoint: ApiEndpoint,
    val accessKey: String = productName,
) {
    HAWK("Hawk", "cc53af24d1f6f1b72146c89d33c26d48", "A7H10", ApiEndpoint.CHINA), //TODO
    PHOENIX("Phoenix", "159f4d7322318a36c1b77837f7568c0c", "A8110", ApiEndpoint.CHINA),
    G2_4K("Pico_G2_4K", "4009d3356cf795ded9d69833c2735bbb", "A7510", ApiEndpoint.CHINA), //TODO
    G3("PICO_G3", "d22def96977260f2c243fe9888f7c3b8", "A7Q10", ApiEndpoint.CHINA),
    NEO_3("Pico_Neo_3", "50298ef2480372dae9e6cd430009efcd", "A7H10", ApiEndpoint.CHINA), // TODO
    SPARROW("sparrow", "704e4b99392d8cf6b069467582e5e510", "A9210", ApiEndpoint.CHINA),

    PHOENIX_GLOBAL("Phoenix_ovs", "223ecf843a8ad96f99ee3f92c54e164f", "A8110", ApiEndpoint.GLOBAL),
    G3_GLOBAL("PICO_G3", "4b6fe3c0e550f9192e8b51af7b99b708", "A7Q10", ApiEndpoint.GLOBAL),
    NEO_3_GLOBAL("Pico_Neo_3", "50298ef2480372dae9e6cd430009efcd", "A7H10", ApiEndpoint.GLOBAL), // TODO
    NEO_3_PRO_EYE_GLOBAL(
        "Pico_Neo_3_Pro_Eye",
        "50298ef2480372dae9e6cd430009efcd",
        "A7H10",
        ApiEndpoint.GLOBAL,
        "Pico_Neo_3"
    ), // TODO
    NEO_3_LINK_GLOBAL("Pico_Neo_3_Link", "7502f432280c2ac96d4494518cc300c1", "A7H10", ApiEndpoint.GLOBAL), // TODO
    SPARROW_GLOBAL("sparrow", "73e0123394eb6ce8e09055f6f97c4e17", "A9210", ApiEndpoint.GLOBAL),
}