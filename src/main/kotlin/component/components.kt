package component

import component.loading.LoadingSpinner
import kotlinx.css.LinearDimension
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.px
import kotlinx.html.DIV
import react.RBuilder
import react.dom.attrs
import styled.StyledDOMBuilder
import styled.css
import styled.styledA
import styled.styledImg

fun RBuilder.loadingComponent() = LoadingSpinner {
    attrs {
        type="MutatingDots"
        color="green"
        height=100
        width=100
    }
}

fun StyledDOMBuilder<DIV>.iconButton(url:String, iconName:String) = styledA(url) {
    styledImg(src = "icon/$iconName.svg", alt = iconName) {
        attrs {
            width = "32"
            height = "32"


        }
    }

    css {
        padding="100"
    }
}