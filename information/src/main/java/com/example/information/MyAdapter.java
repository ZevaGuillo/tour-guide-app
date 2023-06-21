package com.example.information;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MyData> dataList; // Lista de datos de tu base de datos
    private int[] staticImages = {R.drawable.malecon2000, R.drawable.guayarte,R.drawable.parquesamanes,
            R.drawable.cerrosantana, R.drawable.parquehistorico, R.drawable.parqueseminario, R.drawable.restaurantepatio,
            R.drawable.casajulian, R.drawable.noesushi, R.drawable.catedral
    };
    public Map<String, List<Integer>> categoryImageMap;

    private List<MyData> dataListOriginal;

    public String searchQuery = "";
    public MyAdapter(List<MyData> dataList, Map<String, List<Integer>> categoryImageMap) {
        this.dataList = dataList;
        dataListOriginal = new ArrayList<>();
        dataListOriginal.addAll(dataList);

        this.categoryImageMap = new HashMap<>();
        List<Integer> parqueImages = new ArrayList<>();
        parqueImages.add(R.drawable.malecon2000);
        parqueImages.add(R.drawable.parquesamanes);
        parqueImages.add(R.drawable.parquehistorico);
        parqueImages.add(R.drawable.parqueseminario);
        this.categoryImageMap.put("Parque", parqueImages);

        List<Integer> monumentoImages = new ArrayList<>();
        monumentoImages.add(R.drawable.cerrosantana);
        monumentoImages.add(R.drawable.catedral);
        this.categoryImageMap.put("Monumento", monumentoImages);

        List<Integer> restauranteImages = new ArrayList<>();
        restauranteImages.add(R.drawable.casajulian);
        restauranteImages.add(R.drawable.noesushi);
        restauranteImages.add(R.drawable.restaurantepatio);
        this.categoryImageMap.put("Restaurante", restauranteImages);
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
       // MyData data = dataList.get(position);
        MyData data = dataList.get(position);
        holder.textView.setText(data.getnombre());

        String categoria = data.getCategoria().toLowerCase(Locale.getDefault());
        List<Integer> categoryImages = null;
        if (categoryImageMap != null) {
            categoryImages = categoryImageMap.get(categoria);
        }

        if (TextUtils.isEmpty(searchQuery) || categoria.contains(searchQuery.toLowerCase(Locale.getDefault()))) {
            holder.itemView.setVisibility(View.VISIBLE);

            if (categoryImages != null && !categoryImages.isEmpty()) {
                int randomImageIndex = new Random().nextInt(categoryImages.size());
                int imageResource = categoryImages.get(randomImageIndex);
                holder.imageView.setImageResource(imageResource);
            }
        } else {
            holder.itemView.setVisibility(View.GONE);
        }

       /* int imageResource = staticImages[position % staticImages.length];
        holder.imageView.setImageResource(imageResource);

        MyData data = dataList.get(position);
        holder.textView.setText(data.getnombre());

        if (TextUtils.isEmpty(searchQuery)) {
            holder.itemView.setVisibility(View.VISIBLE);
        } else {
            String categoria = data.getCategoria().toLowerCase(Locale.getDefault());
            if (categoria.contains(searchQuery.toLowerCase(Locale.getDefault()))) {
                holder.itemView.setVisibility(View.VISIBLE);
            } else {
                holder.itemView.setVisibility(View.GONE);
            }
        }*/


        /*int imageResource = staticImages[position % staticImages.length];
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
        holder.itemView.setVisibility(View.VISIBLE);*/

        // Obtener la imagen correspondiente según la categoría


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

    public void filtrado(String searc_viewcategoria) {
        int longitud = searc_viewcategoria.length();
        if (longitud == 0) {
            dataList.clear();
            dataList.addAll(dataListOriginal);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<MyData> collection = dataList.stream()
                        .filter(i -> i.getCategoria().toLowerCase().contains(searc_viewcategoria.toLowerCase()))
                        .collect(Collectors.toList());
                dataList.clear();
                dataList.addAll(collection);
            } else {
                for (MyData c : dataListOriginal) {
                    if (c.getCategoria().toLowerCase().contains(searc_viewcategoria.toLowerCase())) {
                        dataList.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public void setDataList(List<MyData> dataList) {
        this.dataList = dataList;
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
