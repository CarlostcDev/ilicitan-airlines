package com.carlostcdev.ilicitanairlines.ui.theme

object IlicitanColors {
    object Text {
        val defaultPrimary = Palette.black
        val pressed = Palette.white
        val secondary = Palette.primary
        val disabled = Palette.gray
        val defaultSecondary = Palette.white
    }

    object Icon {
        val defaultPrimary = Palette.dark
        val defaultSecondary = Palette.white
        val disabled = Palette.gray
    }

    object Surface {
        val defaultPrimary = Palette.white
        val defaultSecondary = Palette.primary
        val borderSuccess = Palette.success
        val borderWarn = Palette.warn
        val borderAlert = Palette.error
    }

    object Button {
        val default = Palette.primary
        val primaryPressed = Palette.secondary
        val secondaryPressed = Palette.silverGray
        val primaryDisabled = Palette.blackGray
        val secondaryDisabled = Palette.gray
        val contentDisabled = Palette.white
        val contentEnabled = Palette.white
    }

    object Input {
        val defaultBackground = Palette.lightGray
    }
}