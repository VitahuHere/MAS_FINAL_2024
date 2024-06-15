import {
  Paper,
  Table,
  TableBody,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";
import CustomTableCell from "./CustomTableCell.tsx";

export default function DataTable({
  headers,
  data,
}: {
  headers: any[];
  data: any[];
}) {
  return (
    <TableContainer
      component={Paper}
      sx={{
        backgroundColor: "transparent",
      }}
    >
      <Table>
        <TableHead>
          <TableRow>
            {headers.map((header) => (
              <CustomTableCell
                align={header.align}
                text={header.name}
                width={header.width}
              />
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row, rowIndex) => (
            <TableRow key={rowIndex}>
              {headers.map((header, colIndex) => (
                <CustomTableCell
                  key={colIndex}
                  align={header.align}
                  text={row[Object.keys(row)[colIndex]]}
                  width={header.width}
                />
              ))}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
