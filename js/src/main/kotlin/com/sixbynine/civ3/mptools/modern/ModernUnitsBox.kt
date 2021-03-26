package com.sixbynine.civ3.mptools.modern

import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.table.*
import kotlinx.css.*
import react.*
import styled.*

class ModernUnitsBox : RComponent<ModernUnitsBoxProps, RState>() {
  override fun RBuilder.render() {
    mPaper {
      css {
        width = 100.pct
        marginTop = 16.px
        overflowX = Overflow.auto
      }

      mTable {
        mTableHead {
          mTableRow {
            mTableCell {
              styledDiv {
                css {
                  fontWeight = FontWeight.bold
                }
                +"Name"
              }
            }
            mTableCell {
              styledDiv {
                css {
                  fontWeight = FontWeight.bold
                }
                +"Description"
              }
            }
            mTableCell {
              styledDiv {
                css {
                  fontWeight = FontWeight.bold
                }
                +"Resources"
              }
            }
          }
        }
        mTableBody {
          ModernUnit.getAvailableUnits(props.availableResources).forEach {
            mTableRow {
              mTableCell { +it.label }
              mTableCell { +it.description }
              mTableCell { +it.resourcesDescription }
            }
          }
        }
      }
    }
  }
}

external interface ModernUnitsBoxProps : RProps {
  var availableResources : Set<ModernResource>
}

fun RBuilder.modernUnitsBox(availableResources: Set<ModernResource>): ReactElement {
  return child(ModernUnitsBox::class) {
    attrs.availableResources = availableResources
  }
}