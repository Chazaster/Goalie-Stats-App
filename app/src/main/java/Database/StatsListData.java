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

public class StatsListData extends ArrayAdapter {
    List list = new ArrayList();

    public StatsListData (Context context, int resource) { super(context, resource); }

    static class LayoutHandler { TextView SAVES, SHOTS_AGAINST, GOALS_AGAINST, SAVE_PERCENTAGE, GOALS_AGAINST_AVG; }

    @Override
    public void add (Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() { return list.size(); }

    @Override
    public Object getItem (int position) { return list.get(position); }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_userstats, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.SAVES = (TextView)row.findViewById(R.id.user_total_saves);
            layoutHandler.SHOTS_AGAINST = (TextView)row.findViewById(R.id.user_total_shots_against);
            layoutHandler.GOALS_AGAINST = (TextView)row.findViewById(R.id.user_total_goals_against);
            layoutHandler.SAVE_PERCENTAGE = (TextView)row.findViewById(R.id.user_save_percentage);
            layoutHandler.GOALS_AGAINST_AVG = (TextView)row.findViewById(R.id.user_goals_against_average);
            row.setTag(layoutHandler);
        }
        else layoutHandler = (LayoutHandler)row.getTag();

        StatsDataProvider dataProvider = (StatsDataProvider)this.getItem(position);
        layoutHandler.SAVES.setText(dataProvider.getSaves());
        layoutHandler.SHOTS_AGAINST.setText(dataProvider.getShotsAgainst());
        layoutHandler.GOALS_AGAINST.setText(dataProvider.getGoalsAgainst());
        layoutHandler.SAVE_PERCENTAGE.setText(dataProvider.getSavePercentage());
        layoutHandler.GOALS_AGAINST_AVG.setText(dataProvider.getGoalsAgainstAvg());

        return row;
    }
}

