package com.yasmen.smartangle.Adapters

import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yasmen.smartangle.Model.itemsModel
import com.yasmen.smartangle.R
import com.yasmen.smartangle.Interfaces.RecyclerIndexInterface

class RecyclerAdapter(private val recyclerIndexInterface: RecyclerIndexInterface, private val items: List<itemsModel>) :
    RecyclerView.Adapter<RecyclerAdapter.viewHolder>() {
    var selectedRBPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.viewHolder {
        val inflatedView = parent.inflate(R.layout.recycler_item, false)
        return viewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.viewHolder, position: Int) {

      //____________Get Data from List ___________________________________________
        var questionTitle: String = items.get(position).question
        var questionMessage: String = items.get(position).message
        var questionPounds: String = items.get(position).pounds
        var questionSelected: Boolean = items.get(position).selected

        //___________ bind data with views
        bindDataWithViews(holder,selectedRBPosition,questionTitle,questionMessage,questionPounds,position)


    }

    private fun bindDataWithViews(holder: RecyclerAdapter.viewHolder,
                                  selectedRBPosition: Int,
                                  questionTitle: String,
                                  questionMessage: String,
                                  questionPounds: String,
                                  position: Int) {

        holder.questionTv.text = questionTitle
        holder.questionMsgTv.text = questionMessage
        holder.poundsTv.text = questionPounds
        holder.radioBtn.setChecked(selectedRBPosition == position);

        singleRadioButtonChecked(holder,selectedRBPosition,position)


    }

     fun singleRadioButtonChecked(holder: RecyclerAdapter.viewHolder,selectedRBPosition: Int, position: Int) {
        if(selectedRBPosition == position){
            holder.radioBtn.setChecked(true);
            recyclerIndexInterface.setItemPosition(position)    //send position to interface if radio button is checked

        }else{
            holder.radioBtn.setChecked(false)
        }
        var finalPosition :Int = position;
        holder.radioBtn.setOnClickListener(View.OnClickListener {
            this.selectedRBPosition = finalPosition;
            notifyDataSetChanged()
        })
    }

    override fun getItemCount() = items.size

    class viewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var view: View = v

        var radioBtn: RadioButton
        var questionTv: TextView
        var questionMsgTv: TextView
        var poundsTv: TextView
        var clickedItemindex: Int = -1

        init {
            v.setOnClickListener(this)
            radioBtn = v.findViewById(R.id.radioBtn)
            questionTv = v.findViewById(R.id.questionTv)
            questionMsgTv = v.findViewById(R.id.questionMsgTv)
            poundsTv = v.findViewById(R.id.poundsTv)

        }

        override fun onClick(v: View?) {
        }




    }

}