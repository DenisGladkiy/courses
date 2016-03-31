package stuff;

/**
 * Created by Денис on 3/31/16.
 */
public class SortRows {

    public String[][] sortTable(String[] select){
        String[][] sortedTable = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM carmarket.advert \" +\n" +
                "\" INNER JOIN  carmarket.car ON carmarket.advert.idcar = \" +\n" +
                "\"carmarket.car.idcar INNER JOIN carmarket.owner ON carmarket.car.idowner = carmarket.owner.idowner ");
        if(!select[0].equals("")&&!select[1].equals("")){
            stringBuilder.append("WHERE manufacturer = " + "'"+select[0]+"'"+ " AND model = " + "'"+select[1]+"'");
        }else if(!select[0].equals("")){
            stringBuilder.append("WHERE manufacturer = " + "'"+select[0]+"'");
        }else if(!select[1].equals("")){
            stringBuilder.append("WHERE manufacturer = " + "'"+select[1]+"'");
        }

        return sortedTable;
    }

}
