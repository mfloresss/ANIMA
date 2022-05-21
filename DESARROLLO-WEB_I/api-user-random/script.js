const getUser = async () => {
  const requestAPI = await fetch(`https://randomuser.me/api/?results=5`);
  return (data = requestAPI.json());
};

const randomUser = async () => {
  const user = await getUser();
  const html = user.results.map((user) => {
    return `
    <div class="card bg-transparent">
      <img src="${user.picture.large}" class="card-img-top" />
      <div class="card-body">
        <h5 class="card-title">${user.name.first} ${user.name.last}</h5>
        <p class="card-text">${user.gender}</p>
        <p class="card-text">${user.location.country}</p>
        <p class="card-title">${user.location.city}</p>
        <p class="card-title">${user.location.state}</p>
      </div>
      <ul class="list-group list-group-flush">
        <li class="list-group-item bg-transparent">${user.phone}</li>
        <li class="list-group-item bg-transparent">${user.email}</li>
      </ul>
    </div>
    `;
  });
  const div = document.querySelector(".container-cards");
  div.innerHTML = html.join("");
};

randomUser();
