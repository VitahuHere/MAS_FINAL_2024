import { TableCell } from "@mui/material";

export default function CustomTableCell(props: any) {
  return (
    <TableCell
      sx={{
        color: "white",
        fontSize: "16px",
        "&:last-child": {
          borderRight: 0,
        },
        borderRight: "1px solid #ffffff",
        paddingTop: "6px",
        paddingBottom: "6px",
        cursor: "pointer",
      }}
      {...props}
    >
      {props.text.length > 50 ? `${props.text.slice(0, 50)}...` : props.text}
    </TableCell>
  );
}
