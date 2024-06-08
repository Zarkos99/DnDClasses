package sweng888.project.dndclasses

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.ListView


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load list data
        val dnd_classes = loadDnDClassData(this@MainActivity)
        val adapter = DnDClassListAdaptor(this@MainActivity, dnd_classes)

        val dnd_classes_list_view = findViewById<ListView>(R.id.dnd_class_list_view)
        dnd_classes_list_view.adapter = adapter

        //If the adaptor is empty this will display instead of the list
        dnd_classes_list_view.emptyView = findViewById(R.id.empty_list_view)

        dnd_classes_list_view.setOnItemClickListener { parent, _, position, _ ->
            val selected_dnd_class = parent.getItemAtPosition(position)

            val intent = Intent(this@MainActivity, DnDClassListItemActivity::class.java)
            intent.putExtra(
                "selected_class",
                selected_dnd_class as Parcelable
            )
            startActivity(intent)
        }
    }
}

private fun loadDnDClassData(context: Context): ArrayList<DnDClass> {
    val classes = ArrayList<DnDClass>()
    classes.add(
        DnDClass(
            "Bard",
            context.getString(R.string.bard_description), 8, true
        )
    )
    classes.add(
        DnDClass(
            "Cleric",
            context.getString(R.string.cleric_description), 8, true
        )
    )
    classes.add(
        DnDClass(
            "Rogue",
            context.getString(R.string.rogue_description), 8, false
        )
    )
    classes.add(
        DnDClass(
            "Sorcerer",
            context.getString(R.string.sorcerer_description), 6, true
        )
    )

    return classes
}