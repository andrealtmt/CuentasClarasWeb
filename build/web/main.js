function goToLogin() {
  window.location.href = "login.html";
}

function goToSignUp() {
  window.location.href = "signup.html";
}

function login(event) {
  event.preventDefault();

  const emailValue = document.getElementById("email").value;
  const passValue = document.getElementById("password").value;

  const appContext = window.location.pathname.split("/")[1];
  fetch(`/${appContext}/api/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      email: emailValue,
      password: passValue,
    }),
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error(`Error en la solicitud: ${response.statusText}`);
      }
    })
    .then((data) => {
      console.log(data);
      if (data !== null) {
        localStorage.setItem("usuario", JSON.stringify(data));
        console.log(localStorage);
        location.href = "./homepage.html";
      } else {
        Swal.fire({
          text: "Usuario no encontrado",
          icon: "info",
          confirmButtonText: "Intentar de nuevo",
        }).then((result) => {
          if (result.isConfirmed) {
            userInput.value = passInput.value = "";
          }
        });
      }
    })
    .catch((error) => {
      // Manejar errores de red u otros errores
      console.error("Error en la solicitud:", error);
    });
}

function createUser(event) {
  event.preventDefault();

  const emailValue = document.getElementById("email").value;
  const passValue = document.getElementById("password").value;
  const nameValue = document.getElementById("nombre").value;

  const appContext = window.location.pathname.split("/")[1];
  fetch(`/${appContext}/api/login/create`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      email: emailValue,
      password: passValue,
      nombre: nameValue,
      tipo: 2
    }),
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error(`Error en la solicitud: ${response.statusText}`);
      }
    })
    .then((data) => {
      console.log(data);
      if (data !== null) {
        localStorage.setItem("usuario", JSON.stringify(data));
        console.log(localStorage);
        location.href = "./login.html";
      } else {
        Swal.fire({
          text: "Usuario no encontrado",
          icon: "info",
          confirmButtonText: "Intentar de nuevo",
        }).then((result) => {
          if (result.isConfirmed) {
            userInput.value = passInput.value = "";
          }
        });
      }
    })
    .catch((error) => {
      // Manejar errores de red u otros errores
      console.error("Error en la solicitud:", error);
    });
}
