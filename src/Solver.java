import java.util.HashMap;
import java.util.Map;

public class Solver {

    private Integer blockCount;
    private Integer columnCount;
    private Integer rowCount;

    public Integer countBlocks(Integer rowsOrColumns) {
        Integer result = 0;
        for (Integer i = rowsOrColumns; i > 0; --i) {
            result += i * i;
        }
        return result;
    }

    public Integer getBlockNumber(Integer rowsOrColumns, Integer selectedRow, Integer selectedColumn,
            Integer selectedLayer) {

        StringBuilder pos = new StringBuilder();
        Map<String, Integer> blockPositions = new HashMap<>();

        Integer x = 0, y = 1, z = 1;
        Integer rows = rowsOrColumns;
        for (Integer i = 1; i <= countBlocks(rowsOrColumns); ++i) {
            if (x < rows) {
                ++x;
            } else if (y < rows) {
                x = 1;
                ++y;
            } else if (z < rows * rows) {
                x = 1;
                y = 1;
                ++z;
                --rows;
            }

            pos.append(x);
            pos.append(y);
            pos.append(z);

            blockPositions.put(pos.toString(), i);

            pos.setLength(0);
        }

        pos.append(selectedColumn);
        pos.append(selectedRow);
        pos.append(selectedLayer);

        return blockPositions.get(pos.toString());
    }

    public Integer getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(Integer blockCount) {
        this.blockCount = blockCount;
    }

    public Integer getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }
}
