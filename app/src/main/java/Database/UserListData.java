/* Created by Chase Watson */

package Database;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import com.chase.statsapp.R;

public class UserListData extends ArrayAdapter {
    List list = new ArrayList();

    public UserListData(Context context, int resource) { super(context, resource); }

    static class LayoutHandler { TextView NAME, NUMBER, TEAM; }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() { return list.size(); }

    @Override
    public Object getItem(int position) { return list.get(position); }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME = (TextView)row.findViewById(R.id.text_user_name);
            layoutHandler.NUMBER = (TextView)row.findViewById(R.id.text_user_number);
            layoutHandler.TEAM = (TextView)row.findViewById(R.id.text_user_team);
            row.setTag(layoutHandler);
        }
        else layoutHandler = (LayoutHandler)row.getTag();

        UserDataProvider dataProvider = (UserDataProvider)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.NUMBER.setText(dataProvider.getNumber());
        layoutHandler.TEAM.setText(dataProvider.getTeam());

        return row;
    }
}
