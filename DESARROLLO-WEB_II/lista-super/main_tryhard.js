const { useState } = React;
const root = document.getElementById("root");

const ListItem = ({ item, marginBottom }) => {
  const [itemDone, setItemDone] = useState(false);

  return (
    <div
      style={{
        width: " 100%",
        padding: "5px 20px",
        marginBottom,
        display: "flex",
        alignItems: " center",
        justifyContent: "space-between",
        background: item.type === "fruta" ? "#4DCCBD" : "#2374AB",
        borderRadius: "20px",
      }}
    >
      <li
        style={{
          color: "#fff",
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
  const listDefault = [
    {
      type: "fruta",
      data: "naranja",
    },
    {
      type: "fruta",
      data: "manzana",
    },
    {
      type: "alimento",
      data: "cereal",
    },
    {
      type: "alimento",
      data: "pan",
    },
  ];

  const [list, setList] = useState(listDefault);
  const [hiddenForm, setHiddenForm] = useState(true);

  return (
    <>
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
      <FloatingButton
        onClick={() => setHiddenForm(!hiddenForm)}
        hidden={hiddenForm}
      />
      <ListForm hidden={hiddenForm} currentList={list} />
    </>
  );
};

const FloatingButton = ({ hidden, ...rest }) => {
  return (
    <button
      style={{
        zIndex: "100",
        width: "70px",
        height: "70px",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        background: "#2374AB",
        borderRadius: "100%",
        position: "absolute",
        right: "0",
        bottom: "0",
        border: "none",
        fontSize: "2rem",
        color: "#ffff",
        margin: "0 20px 20px 0",
        cursor: "pointer",
      }}
      {...rest}
    >
      {hidden ? (
        <span>+</span>
      ) : (
        <span style={{ paddingBottom: "8px" }}>x</span>
      )}
    </button>
  );
};

const ListForm = ({ currentList, hidden }) => {
  const [text, setText] = useState("");
  const [list, setList] = useState(currentList);

  const addItem = () => {
    if (text !== "") {
      const newItem = { type: "fruta", data: text };
      setList([...list, newItem]);
    }
  };

  return (
    !hidden && (
      <div
        className="absoluteListForm"
        style={{
          position: "absolute",
          top: "0",
          width: "100%",
          height: "100vh",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div className="listForm">
          <h1>Agregar item</h1>
          <form
            onSubmit={(ev) => {
              ev.preventDefault();
              setText(ev.target.value);
              addItem;
            }}
          >
            <input type="text" placeholder="Ingrese el nombre" />
            <button type="submit">Agregar</button>
          </form>
        </div>
      </div>
    )
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
