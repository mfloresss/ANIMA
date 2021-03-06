const { useState } = React;
const root = document.getElementById("root");

const ListItem = ({ item, marginBottom }) => {
  const [itemDone, setItemDone] = useState(false);

  return (
    <div
      style={{
        width: "100%",
        padding: "5px 20px",
        marginBottom,
        display: "flex",
        alignItems: " center",
        justifyContent: "space-between",
        background: item.fruta ? "#4DCCBD" : "#2374AB",
        borderRadius: "20px",
      }}
    >
      <li
        style={{
          color: "#ffff",
          textDecoration: itemDone && "line-through",
        }}
      >
        {item.data.toLocaleUpperCase()}
      </li>
      <input
        style={{
          width: "1rem",
          height: "1rem",
        }}
        type="checkbox"
        value={item.data}
        onClick={() => setItemDone(!itemDone)}
      />
    </div>
  );
};

const List = () => {
  const list = [
    {
      data: "manzana",
      fruta: true,
    },
    {
      data: "cereal",
      fruta: false,
    },
    {
      data: "pan",
      fruta: false,
    },
    {
      data: "naranja",
      fruta: true,
    },
    {
      data: "banana",
      fruta: true,
    },
    {
      data: "agua jane",
      fruta: false,
    },
    {
      data: "shampoo",
      fruta: false,
    },
    {
      data: "jabon",
      fruta: false,
    },
  ];

  return (
    <div className="listCard">
      <header>
        <h1 style={{ color: "#231651" }}>Lista super</h1>
      </header>
      <div
        style={{
          width: "100%",
          height: "calc(100% - 87px)",
          padding: "20px 20px",
          overflowY: "auto",
        }}
      >
        {list.map((item, i) => (
          <ListItem
            item={item}
            key={i}
            marginBottom={i !== list.length - 1 && "35px"}
          />
        ))}
      </div>
    </div>
  );
};

const App = () => {
  return (
    <div className="App">
      <List />
    </div>
  );
};

ReactDOM.render(<App />, root);
