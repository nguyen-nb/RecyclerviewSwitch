package com.sau.recyclerviewswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

const val SPAN_COUNT_GRID = 2
const val SPAN_COUNT_LINEAR = 1

class MainActivity : AppCompatActivity() {

    private var layoutManager: GridLayoutManager? = null
    private var adapter: SimpleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = GridLayoutManager(this, SPAN_COUNT_LINEAR)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(GridItemDecoration(30))
        adapter = SimpleAdapter()
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.change_layout -> {
                adapter?.let {
                    when (it.getType()) {
                        SimpleAdapter.ViewType.LIST.ordinal -> {
                            layoutManager?.spanCount = SPAN_COUNT_GRID
                            adapter?.switchType(SimpleAdapter.ViewType.SMALL.ordinal)
                        }
                        SimpleAdapter.ViewType.SMALL.ordinal -> {
                            layoutManager?.spanCount = SPAN_COUNT_LINEAR
                            adapter?.switchType(SimpleAdapter.ViewType.BIG.ordinal)
                        }
                        else -> {
                            layoutManager?.spanCount = SPAN_COUNT_LINEAR
                            adapter?.switchType(SimpleAdapter.ViewType.LIST.ordinal)
                        }
                    }
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
