package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class ImagesDto(
    @Json(name = "original")
    val original: OriginalDto = OriginalDto(),
    @Json(name = "downsized")
    val downsized: DownsizedDto = DownsizedDto(),
    @Json(name = "downsized_large")
    val downsizedLarge: DownsizedLargeDto = DownsizedLargeDto(),
    @Json(name = "downsized_medium")
    val downsizedMedium: DownsizedMediumDto = DownsizedMediumDto(),
    @Json(name = "downsized_small")
    val downsizedSmall: DownsizedSmallDto = DownsizedSmallDto(),
    @Json(name = "downsized_still")
    val downsizedStill: DownsizedStillDto = DownsizedStillDto(),
    @Json(name = "fixed_height")
    val fixedHeight: FixedHeightDto = FixedHeightDto(),
    @Json(name = "fixed_height_downsampled")
    val fixedHeightDownsampled: FixedHeightDownsampledDto = FixedHeightDownsampledDto(),
    @Json(name = "fixed_height_small")
    val fixedHeightSmall: FixedHeightSmallDto = FixedHeightSmallDto(),
    @Json(name = "fixed_height_small_still")
    val fixedHeightSmallStill: FixedHeightSmallStillDto = FixedHeightSmallStillDto(),
    @Json(name = "fixed_height_still")
    val fixedHeightStill: FixedHeightStillDto = FixedHeightStillDto(),
    @Json(name = "fixed_width")
    val fixedWidth: FixedWidthDto = FixedWidthDto(),
    @Json(name = "fixed_width_downsampled")
    val fixedWidthDownsampled: FixedWidthDownsampledDto = FixedWidthDownsampledDto(),
    @Json(name = "fixed_width_small")
    val fixedWidthSmall: FixedWidthSmallDto = FixedWidthSmallDto(),
    @Json(name = "fixed_width_small_still")
    val fixedWidthSmallStill: FixedWidthSmallStillDto = FixedWidthSmallStillDto(),
    @Json(name = "fixed_width_still")
    val fixedWidthStill: FixedWidthStillDto = FixedWidthStillDto(),
    @Json(name = "looping")
    val looping: LoopingDto = LoopingDto(),
    @Json(name = "original_still")
    val originalStill: OriginalStillDto = OriginalStillDto(),
    @Json(name = "original_mp4")
    val originalMp4: OriginalMp4Dto = OriginalMp4Dto(),
    @Json(name = "preview")
    val preview: PreviewDto = PreviewDto(),
    @Json(name = "preview_gif")
    val previewGif: PreviewGifDto = PreviewGifDto(),
    @Json(name = "preview_webp")
    val previewWebp: PreviewWebpDto = PreviewWebpDto(),
    @Json(name = "hd")
    val hd: HdDto? = null,
    @Json(name = "480w_still")
    val wStill: WStillDto = WStillDto()
)