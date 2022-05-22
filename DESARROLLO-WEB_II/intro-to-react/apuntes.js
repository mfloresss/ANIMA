// const root = document.getElementById("root");
const root = document.getElementById("root");

const element = React.createElement("div", {
  className: "element",
  children: "Hello word",
});

const element2 = React.createElement(
  "div",
  {
    className: "element2",
  },
  "Element 2 ",
  "Pepe"
);

// const element3 = <div className="element3">hello word</div>;

ReactDOM.render(<div>pepe</div>, root);

// Renderiza el elemento en el HTML.
// Se le pasa priemero el elemento a renderizar y luego donde queremos que se renderize
// ReactDOM.render(element, root);
// ReactDOM.render(element2, root);

// Agrega contenido al element (div)
// element.textContent = "Hello world";

// Agrega una clase a elelemt (div)
// element.className = "elementClass";

// Inserta el element (div) en el root (div class="root")
// root.appendChild(element);


// Se usa clasName para asignar una clase ya que class es una palabra reservada de js