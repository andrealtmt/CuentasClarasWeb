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
      tipo: 2,
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

function signUp(event) {
  event.preventDefault();

  const emailValue = document.getElementById("email").value;
  const passValue = document.getElementById("password").value;
  const nombreValue = document.getElementById("nombre").value;

  const appContext = window.location.pathname.split("/")[1];
  fetch(`/${appContext}/api/login/create`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      email: emailValue,
      password: passValue,
      nombre: nombreValue,
      tipo: 2,
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
        alert("Usuario creado. Serás redirigido al inicio de sesión.");
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

function logout() {
  const confirmLogout = confirm("¿Estás seguro de que quieres cerrar sesión?");
  if (confirmLogout) {
    localStorage.removeItem("usuario");
    // Redirigir al usuario a la página de inicio
    history.pushState(null, "", "./index.html");
    // Forzar una recarga de la página
    window.location.reload();
  }
}

function checkAuth() {
  const user = JSON.parse(localStorage.getItem("usuario"));
  if (!user && window.location.pathname !== "/index.html") {
    // Si no hay usuario autenticado y no estamos en la página de inicio,
    // redirigir a la página de inicio
    window.location.href = ".index.html";
  }
}

// Obtener el nombre del usuario del almacenamiento local
document.addEventListener("DOMContentLoaded", function () {
  const user = JSON.parse(localStorage.getItem("usuario"));
  if (user) {
    // Si hay un usuario almacenado, actualizar el nombre de usuario en la página
    const userNameElement = document.getElementById("user-name");
    userNameElement.textContent = user.nombre;

    // También puedes actualizar el mensaje de bienvenida si lo deseas
    const welcomeMessageElement = document.getElementById("welcome-message");
    welcomeMessageElement.textContent += user.nombre;
  }
});
