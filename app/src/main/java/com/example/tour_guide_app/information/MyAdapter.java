package com.example.tour_guide_app.information;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tour_guide_app.R;

import java.util.ArrayList;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MyData> dataList;
    private int[] staticImages = {R.drawable.malecon2000, R.drawable.guayarte,R.drawable.parquesamanes,
            R.drawable.cerrosantana, R.drawable.parquehistorico, R.drawable.parqueseminario, R.drawable.restaurantepatio,
            R.drawable.casajulian, R.drawable.noesushi, R.drawable.catedral
    };

    private List<MyData> dataListOriginal;

    public String searchQuery = "";
    public MyAdapter(List<MyData> dataList) {
        this.dataList = dataList;
        dataListOriginal = new ArrayList<>();
        dataListOriginal.addAll(dataList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        // Crear un nuevo ViewHolder y asignar la vista inflada
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyData data = dataList.get(position);

        int imageResource = staticImages[position % staticImages.length];
        holder.imageView.setImageResource(imageResource);

        // Setear el nombre del lugar
        holder.textView.setText(data.getnombre());

        // Filtrar los datos según el texto de búsqueda
        if (searchQuery != null && !searchQuery.isEmpty()) {
            if (!data.getCategoria().toLowerCase().contains(searchQuery.toLowerCase())) {
                // Ocultar el elemento si no coincide con la búsqueda
                holder.itemView.setVisibility(View.GONE);
                return;
            }
        }

        // Mostrar el elemento si coincide con la búsqueda
        holder.itemView.setVisibility(View.VISIBLE);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    MyData data = dataList.get(position);
                    String nombre = data.getnombre();
                    int imagenResId = staticImages[position];

                    // Crear el Intent y pasar los datos como extras
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DescripcionActivity.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("imagenResId", imagenResId);

                    intent.putExtra("ubicacion", data.getUbicacion());
                    intent.putExtra("categoria", data.getCategoria());
                    intent.putExtra("descripcion", data.getDescripcion());
                    intent.putExtra("precios", data.getPrecios());
                    intent.putExtra("horarios", data.getHorarios());

                    // Iniciar la nueva Activity
                    context.startActivity(intent);
                }
            }
        });
    }
    public void setSearchQuery(String query) {
        searchQuery = query;
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView ubicacionTextView;
        TextView categoriaTextView;
        TextView descripcionTextView;
        TextView preciosTextView;
        TextView horariosTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
            ubicacionTextView = itemView.findViewById(R.id.textViewUbicacion);
            categoriaTextView = itemView.findViewById(R.id.textViewCategoria);
            descripcionTextView = itemView.findViewById(R.id.textViewDescripcion);
            preciosTextView = itemView.findViewById(R.id.textViewHorarios);
            horariosTextView = itemView.findViewById(R.id.textViewPrecios);

        }
    }
}