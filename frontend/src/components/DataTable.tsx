import {
  Paper,
  Table,
  TableBody,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";
import CustomTableCell from "./CustomTableCell.tsx";
import { useNavigate } from "react-router-dom";

export default function DataTable({
  headers,
  data,
  redirectPaths,
}: {
  headers: any[];
  data: any[];
  redirectPaths?: string[];
}) {
  const navigate = useNavigate();

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
                key={header.name}
              />
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row, rowIndex) => (
            <TableRow
              key={rowIndex}
              onClick={() =>
                redirectPaths ? navigate(redirectPaths[rowIndex]) : null
              }
            >
              {headers.map((header, colIndex) => {
                return (
                  <CustomTableCell
                    key={colIndex}
                    align={header.align}
                    text={row[Object.keys(row)[colIndex]]}
                    width={header.width}
                  />
                );
              })}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
