package sweng888.project.dndclasses

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DnDClassListItemActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dnd_class_info)

        val selected_class = intent.extras?.get("selected_class") as DnDClass

        val text_view_class_name = findViewById<TextView>(R.id.textview_class_name)
        val text_view_hit_die = findViewById<TextView>(R.id.textview_class_hit_die)
        val text_view_can_spellcast =
            findViewById<TextView>(R.id.textview_class_can_spellcast)
        val text_view_description = findViewById<TextView>(R.id.textview_class_description)
        val text_view_class_image =
            findViewById<ImageView>(R.id.class_image_view)

        text_view_class_name.text = selected_class.class_name
        text_view_hit_die.text =
            this@DnDClassListItemActivity.getString(R.string.hit_die_label) + selected_class.hit_die
        text_view_can_spellcast.text =
            this@DnDClassListItemActivity.getString(R.string.spellcasting_label) + (if (selected_class!!.can_spellcast) "yes" else "no")
        text_view_description.text = selected_class.description
        text_view_class_image.setImageDrawable(getImage(selected_class?.class_name?.lowercase()))

        val m_back_button_view = findViewById<Button>(R.id.back_button)

        m_back_button_view.setOnClickListener {
            val intent = Intent(this@DnDClassListItemActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getImage(ImageName: String?): Drawable {
        return this@DnDClassListItemActivity.resources.getDrawable(
            this@DnDClassListItemActivity.resources.getIdentifier(
                ImageName,
                "drawable",
                this@DnDClassListItemActivity.packageName
            )
        )
    }
}
