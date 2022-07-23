package com.edu.pe.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.edu.pe.R;
import com.edu.pe.modelo.Citas;

import java.util.List;

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.ViewHolder> implements View.OnClickListener{
    private List<Citas> lista;
    private View.OnClickListener click;
    @Override
    public void onClick(View view) {
        if(click !=null){
            click.onClick(view);
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombreMedico , fechaCita, horaCita;
        ImageView fotoMedico;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreMedico = (TextView)itemView.findViewById(R.id.txtDesc1);
            fechaCita = (TextView)itemView.findViewById(R.id.txtDesc2);
            horaCita = (TextView) itemView.findViewById(R.id.txtDesc3);
            fotoMedico = (ImageView)itemView.findViewById(R.id.imageView1);
        }
    }
    public CitaAdapter(List<Citas> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mis_citas , parent , false);
        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    public void setOnClickListener(View.OnClickListener click){
        this.click = click;
    }

    //Realiza las modificaciones de cada item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Citas a = lista.get(position);
        holder.nombreMedico.setText("Medico : "+a.getNomMedico());
        holder.fechaCita.setText("Fecha Cita : "+a.getFecha_cita());
        holder.horaCita.setText("Hora Cita   : "+a.getHora_cita());
        holder.fotoMedico.setImageResource(R.drawable.imagen_medico);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
