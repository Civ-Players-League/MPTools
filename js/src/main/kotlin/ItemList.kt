import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.table.*
import kotlinx.css.*
import react.*
import styled.*

class ItemList : RComponent<ItemListProps, RState>() {
  override fun RBuilder.render() {
    mPaper {
      css {
        width = 100.pct
        marginTop = 72.px
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
                +"Column 1"
              }
            }
            mTableCell(align = MTableCellAlign.right) {
              styledDiv {
                css {
                  fontWeight = FontWeight.bold
                }
                +"Column 2"
              }
            }
          }
        }
        mTableBody {
          props.items.forEach {
            mTableRow {
              mTableCell { +it }
              mTableCell(align = MTableCellAlign.right) { +it }
            }
          }
        }
      }
    }
  }
}

fun RBuilder.itemList(websiteInfos: List<String>): ReactElement {
  return child(ItemList::class) {
    attrs.items = websiteInfos
  }
}

external interface ItemListProps : RProps {
  var items: List<String>
}