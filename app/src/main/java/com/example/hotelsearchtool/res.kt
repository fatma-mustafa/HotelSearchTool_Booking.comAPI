//package com.example.hotelsearchtool
//
//
//import com.google.gson.annotations.SerializedName
//
//data class res(
//    @SerializedName("count")
//    val count: Int,
//    @SerializedName("extended_count")
//    val extendedCount: Int,
//    @SerializedName("map_bounding_box")
//    val mapBoundingBox: MapBoundingBox,
//    @SerializedName("primary_count")
//    val primaryCount: Int,
//    @SerializedName("result")
//    val result: List<Result>,
//    @SerializedName("room_distribution")
//    val roomDistribution: List<RoomDistribution>,
//    @SerializedName("search_radius")
//    val searchRadius: Double,
//    @SerializedName("sort")
//    val sort: List<Sort>,
//    @SerializedName("total_count_with_filters")
//    val totalCountWithFilters: Int,
//    @SerializedName("unfiltered_count")
//    val unfilteredCount: Int,
//    @SerializedName("unfiltered_primary_count")
//    val unfilteredPrimaryCount: Int
//) {
//
//
//    data class Result(
//        @SerializedName("accommodation_type")
//        val accommodationType: Int,
//        @SerializedName("accommodation_type_name")
//        val accommodationTypeName: String,
//        @SerializedName("address")
//        val address: String,
//        @SerializedName("address_trans")
//        val addressTrans: String,
//        @SerializedName("badges")
//        val badges: List<Badge>,
//        @SerializedName("block_ids")
//        val blockIds: List<String>,
//        @SerializedName("booking_home")
//        val bookingHome: BookingHome,
//        @SerializedName("bwallet")
//        val bwallet: Bwallet,
//        @SerializedName("cant_book")
//        val cantBook: Int,
//        @SerializedName("cc1")
//        val cc1: String,
//        @SerializedName("cc_required")
//        val ccRequired: Int,
//        @SerializedName("checkin")
//        val checkin: Checkin,
//        @SerializedName("checkout")
//        val checkout: Checkout,
//        @SerializedName("children_not_allowed")
//        val childrenNotAllowed: Int,
//        @SerializedName("city")
//        val city: String,
//        @SerializedName("city_in_trans")
//        val cityInTrans: String,
//        @SerializedName("city_name_en")
//        val cityNameEn: String,
//        @SerializedName("city_trans")
//        val cityTrans: String,
//        @SerializedName("class_is_estimated")
//        val classIsEstimated: Int,
//        @SerializedName("class")
//        val classX: Double,
//        @SerializedName("composite_price_breakdown")
//        val compositePriceBreakdown: CompositePriceBreakdown,
//        @SerializedName("country_trans")
//        val countryTrans: String,
//        @SerializedName("countrycode")
//        val countrycode: String,
//        @SerializedName("cpc_non_trader_copy")
//        val cpcNonTraderCopy: String,
//        @SerializedName("currency_code")
//        val currencyCode: String,
//        @SerializedName("currencycode")
//        val currencycode: String,
//        @SerializedName("default_language")
//        val defaultLanguage: String,
//        @SerializedName("default_wishlist_name")
//        val defaultWishlistName: String,
//        @SerializedName("distance")
//        val distance: String,
//        @SerializedName("distance_to_cc")
//        val distanceToCc: String,
//        @SerializedName("distance_to_city_centre_formatted")
//        val distanceToCityCentreFormatted: String,
//        @SerializedName("distances")
//        val distances: List<Distance>,
//        @SerializedName("district")
//        val district: String,
//        @SerializedName("district_id")
//        val districtId: Int,
//        @SerializedName("districts")
//        val districts: String,
//        @SerializedName("extended")
//        val extended: Int,
//        @SerializedName("genius_discount_percentage")
//        val geniusDiscountPercentage: Int,
//        @SerializedName("has_free_parking")
//        val hasFreeParking: Int,
//        @SerializedName("has_swimming_pool")
//        val hasSwimmingPool: Int,
//        @SerializedName("hotel_facilities")
//        val hotelFacilities: String,
//        @SerializedName("hotel_has_vb_boost")
//        val hotelHasVbBoost: Int,
//        @SerializedName("hotel_id")
//        val hotelId: Int,
//        @SerializedName("hotel_include_breakfast")
//        val hotelIncludeBreakfast: Int,
//        @SerializedName("hotel_name")
//        val hotelName: String,
//        @SerializedName("hotel_name_trans")
//        val hotelNameTrans: String,
//        @SerializedName("id")
//        val id: String,
//        @SerializedName("in_best_district")
//        val inBestDistrict: Int,
//        @SerializedName("is_beach_front")
//        val isBeachFront: Int,
//        @SerializedName("is_city_center")
//        val isCityCenter: Int,
//        @SerializedName("is_free_cancellable")
//        val isFreeCancellable: Int,
//        @SerializedName("is_genius_deal")
//        val isGeniusDeal: Int,
//        @SerializedName("is_geo_rate")
//        val isGeoRate: Int,
//        @SerializedName("is_mobile_deal")
//        val isMobileDeal: Int,
//        @SerializedName("is_no_prepayment_block")
//        val isNoPrepaymentBlock: Int,
//        @SerializedName("is_smart_deal")
//        val isSmartDeal: Int,
//        @SerializedName("latitude")
//        val latitude: Double,
//        @SerializedName("longitude")
//        val longitude: Double,
//        @SerializedName("main_photo_id")
//        val mainPhotoId: Int,
//        @SerializedName("main_photo_url")
//        val mainPhotoUrl: String,
//        @SerializedName("matching_units_configuration")
//        val matchingUnitsConfiguration: MatchingUnitsConfiguration,
//        @SerializedName("max_1440_photo_url")
//        val max1440PhotoUrl: String,
//        @SerializedName("max_photo_url")
//        val maxPhotoUrl: String,
//        @SerializedName("min_total_price")
//        val minTotalPrice: Double,
//        @SerializedName("mobile_discount_percentage")
//        val mobileDiscountPercentage: Double,
//        @SerializedName("native_ad_id")
//        val nativeAdId: String,
//        @SerializedName("native_ads_cpc")
//        val nativeAdsCpc: Double,
//        @SerializedName("native_ads_tracking")
//        val nativeAdsTracking: String,
//        @SerializedName("preferred")
//        val preferred: Int,
//        @SerializedName("preferred_plus")
//        val preferredPlus: Int,
//        @SerializedName("price_breakdown")
//        val priceBreakdown: PriceBreakdown,
//        @SerializedName("price_is_final")
//        val priceIsFinal: Int,
//        @SerializedName("review_nr")
//        val reviewNr: Int,
//        @SerializedName("review_recommendation")
//        val reviewRecommendation: String,
//        @SerializedName("review_score")
//        val reviewScore: Double,
//        @SerializedName("review_score_word")
//        val reviewScoreWord: String,
//        @SerializedName("ribbon_text")
//        val ribbonText: String,
//        @SerializedName("selected_review_topic")
//        val selectedReviewTopic: Any,
//        @SerializedName("soldout")
//        val soldout: Int,
//        @SerializedName("timezone")
//        val timezone: String,
//        @SerializedName("type")
//        val type: String,
//        @SerializedName("ufi")
//        val ufi: Int,
//        @SerializedName("unit_configuration_label")
//        val unitConfigurationLabel: String,
//        @SerializedName("url")
//        val url: String,
//        @SerializedName("wishlist_count")
//        val wishlistCount: Int,
//        @SerializedName("zip")
//        val zip: String
//    ) {
//        data class Badge(
//            @SerializedName("badge_variant")
//            val badgeVariant: String,
//            @SerializedName("id")
//            val id: String,
//            @SerializedName("text")
//            val text: String
//        )
//
//        data class BookingHome(
//            @SerializedName("group")
//            val group: String,
//            @SerializedName("is_booking_home")
//            val isBookingHome: Int,
//            @SerializedName("is_single_unit_property")
//            val isSingleUnitProperty: Int,
//            @SerializedName("quality_class")
//            val qualityClass: Double,
//            @SerializedName("segment")
//            val segment: Int
//        )
//
//        data class Bwallet(
//            @SerializedName("hotel_eligibility")
//            val hotelEligibility: Int
//        )
//
//        data class Checkin(
//            @SerializedName("from")
//            val from: String,
//            @SerializedName("until")
//            val until: String
//        )
//
//        data class Checkout(
//            @SerializedName("from")
//            val from: String,
//            @SerializedName("until")
//            val until: String
//        )
//
//        data class CompositePriceBreakdown(
//            @SerializedName("all_inclusive_amount")
//            val allInclusiveAmount: AllInclusiveAmount,
//            @SerializedName("benefits")
//            val benefits: List<Benefit>,
//            @SerializedName("discounted_amount")
//            val discountedAmount: DiscountedAmount,
//            @SerializedName("excluded_amount")
//            val excludedAmount: ExcludedAmount,
//            @SerializedName("gross_amount")
//            val grossAmount: GrossAmount,
//            @SerializedName("gross_amount_per_night")
//            val grossAmountPerNight: GrossAmountPerNight,
//            @SerializedName("included_taxes_and_charges_amount")
//            val includedTaxesAndChargesAmount: IncludedTaxesAndChargesAmount,
//            @SerializedName("items")
//            val items: List<Item>,
//            @SerializedName("net_amount")
//            val netAmount: NetAmount,
//            @SerializedName("product_price_breakdowns")
//            val productPriceBreakdowns: List<ProductPriceBreakdown>,
//            @SerializedName("strikethrough_amount")
//            val strikethroughAmount: StrikethroughAmount,
//            @SerializedName("strikethrough_amount_per_night")
//            val strikethroughAmountPerNight: StrikethroughAmountPerNight
//        ) {
//            data class AllInclusiveAmount(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Double
//            )
//
//            data class Benefit(
//                @SerializedName("badge_variant")
//                val badgeVariant: String,
//                @SerializedName("details")
//                val details: String,
//                @SerializedName("icon")
//                val icon: Any,
//                @SerializedName("identifier")
//                val identifier: String,
//                @SerializedName("kind")
//                val kind: String,
//                @SerializedName("name")
//                val name: String
//            )
//
//            data class DiscountedAmount(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Double
//            )
//
//            data class ExcludedAmount(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Int
//            )
//
//            data class GrossAmount(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Double
//            )
//
//            data class GrossAmountPerNight(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Double
//            )
//
//            data class IncludedTaxesAndChargesAmount(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Double
//            )
//
//            data class Item(
//                @SerializedName("base")
//                val base: Base,
//                @SerializedName("details")
//                val details: String,
//                @SerializedName("identifier")
//                val identifier: String,
//                @SerializedName("inclusion_type")
//                val inclusionType: String,
//                @SerializedName("item_amount")
//                val itemAmount: ItemAmount,
//                @SerializedName("kind")
//                val kind: String,
//                @SerializedName("name")
//                val name: String
//            ) {
//                data class Base(
//                    @SerializedName("base_amount")
//                    val baseAmount: Double,
//                    @SerializedName("kind")
//                    val kind: String,
//                    @SerializedName("percentage")
//                    val percentage: Double
//                )
//
//                data class ItemAmount(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//            }
//
//            data class NetAmount(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Double
//            )
//
//            data class ProductPriceBreakdown(
//                @SerializedName("all_inclusive_amount")
//                val allInclusiveAmount: AllInclusiveAmount,
//                @SerializedName("benefits")
//                val benefits: List<Benefit>,
//                @SerializedName("discounted_amount")
//                val discountedAmount: DiscountedAmount,
//                @SerializedName("excluded_amount")
//                val excludedAmount: ExcludedAmount,
//                @SerializedName("gross_amount")
//                val grossAmount: GrossAmount,
//                @SerializedName("gross_amount_per_night")
//                val grossAmountPerNight: GrossAmountPerNight,
//                @SerializedName("included_taxes_and_charges_amount")
//                val includedTaxesAndChargesAmount: IncludedTaxesAndChargesAmount,
//                @SerializedName("items")
//                val items: List<Item>,
//                @SerializedName("net_amount")
//                val netAmount: NetAmount,
//                @SerializedName("strikethrough_amount")
//                val strikethroughAmount: StrikethroughAmount,
//                @SerializedName("strikethrough_amount_per_night")
//                val strikethroughAmountPerNight: StrikethroughAmountPerNight
//            ) {
//                data class AllInclusiveAmount(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//
//                data class Benefit(
//                    @SerializedName("badge_variant")
//                    val badgeVariant: String,
//                    @SerializedName("details")
//                    val details: String,
//                    @SerializedName("icon")
//                    val icon: Any,
//                    @SerializedName("identifier")
//                    val identifier: String,
//                    @SerializedName("kind")
//                    val kind: String,
//                    @SerializedName("name")
//                    val name: String
//                )
//
//                data class DiscountedAmount(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//
//                data class ExcludedAmount(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Int
//                )
//
//                data class GrossAmount(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//
//                data class GrossAmountPerNight(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//
//                data class IncludedTaxesAndChargesAmount(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//
//                data class Item(
//                    @SerializedName("base")
//                    val base: Base,
//                    @SerializedName("details")
//                    val details: String,
//                    @SerializedName("identifier")
//                    val identifier: String,
//                    @SerializedName("inclusion_type")
//                    val inclusionType: String,
//                    @SerializedName("item_amount")
//                    val itemAmount: ItemAmount,
//                    @SerializedName("kind")
//                    val kind: String,
//                    @SerializedName("name")
//                    val name: String
//                ) {
//                    data class Base(
//                        @SerializedName("base_amount")
//                        val baseAmount: Double,
//                        @SerializedName("kind")
//                        val kind: String,
//                        @SerializedName("percentage")
//                        val percentage: Double
//                    )
//
//                    data class ItemAmount(
//                        @SerializedName("currency")
//                        val currency: String,
//                        @SerializedName("value")
//                        val value: Double
//                    )
//                }
//
//                data class NetAmount(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//
//                data class StrikethroughAmount(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//
//                data class StrikethroughAmountPerNight(
//                    @SerializedName("currency")
//                    val currency: String,
//                    @SerializedName("value")
//                    val value: Double
//                )
//            }
//
//            data class StrikethroughAmount(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Double
//            )
//
//            data class StrikethroughAmountPerNight(
//                @SerializedName("currency")
//                val currency: String,
//                @SerializedName("value")
//                val value: Double
//            )
//        }
//
//        data class Distance(
//            @SerializedName("icon_name")
//            val iconName: String,
//            @SerializedName("icon_set")
//            val iconSet: Any,
//            @SerializedName("text")
//            val text: String
//        )
//
//        data class MatchingUnitsConfiguration(
//            @SerializedName("matching_units_common_config")
//            val matchingUnitsCommonConfig: MatchingUnitsCommonConfig
//        ) {
//            data class MatchingUnitsCommonConfig(
//                @SerializedName("localized_area")
//                val localizedArea: String,
//                @SerializedName("unit_type_id")
//                val unitTypeId: Int
//            )
//        }
//
//        data class PriceBreakdown(
//            @SerializedName("all_inclusive_price")
//            val allInclusivePrice: Double,
//            @SerializedName("currency")
//            val currency: String,
//            @SerializedName("gross_price")
//            val grossPrice: Double,
//            @SerializedName("has_fine_print_charges")
//            val hasFinePrintCharges: Int,
//            @SerializedName("has_incalculable_charges")
//            val hasIncalculableCharges: Int,
//            @SerializedName("has_tax_exceptions")
//            val hasTaxExceptions: Int,
//            @SerializedName("sum_excluded_raw")
//            val sumExcludedRaw: String
//        )
//    }
//
//    data class RoomDistribution(
//        @SerializedName("adults")
//        val adults: String,
//        @SerializedName("children")
//        val children: List<Int>
//    )
//
//    data class Sort(
//        @SerializedName("id")
//        val id: String,
//        @SerializedName("name")
//        val name: String
//    )
//}