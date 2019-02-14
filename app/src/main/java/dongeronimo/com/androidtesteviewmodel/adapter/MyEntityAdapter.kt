package dongeronimo.com.androidtesteviewmodel.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import dongeronimo.com.androidtesteviewmodel.R
import dongeronimo.com.androidtesteviewmodel.model.MyEntity
import dongeronimo.com.androidtesteviewmodel.viewModel.MyEntityViewModel
import kotlinx.android.synthetic.main.my_entity.view.*


class MyEntityAdapter
    (
        private val context:Context
    )
    : RecyclerView.Adapter<MyViewHolder>()
{
    lateinit var myEntities:ArrayList<MyEntity> ;
    var viewModel:MyEntityViewModel? =null;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        if(viewModel == null){
            viewModel = ViewModelProviders.of(context as AppCompatActivity).get(MyEntityViewModel::class.java);
        }
        val view = LayoutInflater.from(context).inflate(R.layout.my_entity, parent, false);
        return MyViewHolder(view);
    }
    //ESSE É O 1o
    override fun getItemCount(): Int {
        if(viewModel == null){
            viewModel = ViewModelProviders.of(context as FragmentActivity).get(MyEntityViewModel::class.java);
            viewModel?.models?.observe((context as LifecycleOwner), Observer {
                myEntities = it;
            })
        }
        return myEntities.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(viewModel == null){
            viewModel = ViewModelProviders.of(context as AppCompatActivity).get(MyEntityViewModel::class.java);
        }
        holder.txtNome.text = myEntities[position].name;
        holder.txtDado.text = myEntities[position].data;
    }
}

class MyViewHolder(v:View) : RecyclerView.ViewHolder(v) {
    val txtNome : TextView = v.lbNome;
    val txtDado : TextView = v.lbDado;
}
