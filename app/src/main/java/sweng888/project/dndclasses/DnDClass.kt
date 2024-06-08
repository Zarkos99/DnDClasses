package sweng888.project.dndclasses

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DnDClass(
    val class_name: String = "",
    val description: String = "",
    val hit_die: Int = 0,
    val can_spellcast: Boolean = false
) :
    Parcelable {
}
