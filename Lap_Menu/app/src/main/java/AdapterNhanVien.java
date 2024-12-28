import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lap_menu.R;


public class AdapterNhanVien extends ArrayAdapter<Nhanvien> {
    private Activity context;
    private int resource;

    public AdapterNhanVien(@NonNull Context context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = this.context.getLayoutInflater().inflate(this.resource,null);
        ImageView imgHinh = view.findViewById(R.id.imgHinh);
        return super.getView(position, convertView, parent);
    }
}
