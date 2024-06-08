package sweng888.project.dndclasses

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DnDClassListAdaptor(context: Context, classes: ArrayList<DnDClass>) :
    ArrayAdapter<DnDClass>(context, R.layout.activity_main, classes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val retView: View

        retView = convertView
            ?: LayoutInflater.from(context)
                .inflate(R.layout.dnd_class_list_item, parent, false)

        val dnd_class = getItem(position)

        val text_view_class_name = retView.findViewById<TextView>(R.id.textview_class_name)
        val text_view_hit_die = retView.findViewById<TextView>(R.id.textview_class_hit_die)
        val text_view_can_spellcast =
            retView.findViewById<TextView>(R.id.textview_class_can_spellcast)
        val text_view_class_image =
            retView.findViewById<ImageView>(R.id.class_image_view)

        text_view_class_name.text = dnd_class?.class_name
        text_view_hit_die.text = context.getString(R.string.hit_die_label) + dnd_class?.hit_die
        text_view_can_spellcast.text =
            context.getString(R.string.spellcasting_label) + (if (dnd_class!!.can_spellcast) "Yes" else "No")
        text_view_class_image.setImageDrawable(getImage(dnd_class?.class_name?.lowercase()))
        return retView;
    }

    private fun getImage(ImageName: String?): Drawable {
        return context.resources.getDrawable(
            context.resources.getIdentifier(
                ImageName,
                "drawable",
                context.packageName
            )
        )
    }

}
