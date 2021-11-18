package net.example.android.dictionary.view.history

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_history.*

import net.example.android.dictionary.model.AppState
import net.example.android.dictionary.model.repository.entity.DataModel
import net.example.android.dictionary.view.BaseActivity
import net.example.android.dictionary.view.injectDependencies
import org.koin.android.scope.currentScope


class HistoryActivity : BaseActivity<AppState, HistoryInteractor>() {

    override lateinit var model: HistoryViewModel
    private val adapter: HistoryAdapter by lazy { HistoryAdapter(onListItemClickListener) }

    private val onListItemClickListener: HistoryAdapter.OnListItemClickListener =
        object : HistoryAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                Toast.makeText(this@HistoryActivity, "on click: ${data.text}", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setActionbarHomeButtonAsUp()
        iniViewModel()
        initViews()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {

        super.onResume()
        model.getData("", false)
    }

    override fun setDataToAdapter(data: List<DataModel>) {
        adapter.setData(data)
    }

    private fun iniViewModel() {
        if (history_activity_recyclerview.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        injectDependencies()
        val viewModel: HistoryViewModel by currentScope.inject()
        model = viewModel
        model.subscribe().observe(this@HistoryActivity, Observer<AppState> { renderData(it) })
    }

    private fun initViews() {
        history_activity_recyclerview.adapter = adapter
    }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val data = appState.data
                if (!data.isNullOrEmpty()) {
                    adapter.setData(data)
                }
            }
        }
    }

    private fun setActionbarHomeButtonAsUp() {
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
