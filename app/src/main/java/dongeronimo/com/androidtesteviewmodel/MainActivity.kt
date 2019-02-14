package dongeronimo.com.androidtesteviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import dongeronimo.com.androidtesteviewmodel.adapter.MyEntityAdapter
import dongeronimo.com.androidtesteviewmodel.model.MyEntity
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.LifecycleRegistry



class MainActivity : AppCompatActivity() {
    lateinit var adapter : MyEntityAdapter;
    var list:ArrayList<MyEntity> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add(MyEntity("Charlie","aaaaa"))
        list.add(MyEntity("Baker","bbbbb"))

        adapter = MyEntityAdapter( this)
        myEntityRecyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        myEntityRecyclerView.layoutManager = layoutManager
    }
}
