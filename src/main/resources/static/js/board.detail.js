document.getElementById("delBtn").addEventListener("click", (e) => {
  document.getElementById("delForm").submit();
});

document.getElementById("modBtn").addEventListener("click", (e) => {
  document.getElementById("title").readOnly = false;
  document.getElementById("content").readOnly = false;

  let modBtn = document.createElement("button");
  modBtn.setAttribute("type", "submit");
  modBtn.classList.add("btn", "btn-warning");
  modBtn.innerText = "Submit";
  modBtn.id = "modSubmitBtn";

  document.querySelector("#modBtn").replaceWith(modBtn);

  document.getElementById("delBtn").remove();
});

document.getElementById("listBtn").addEventListener("click", (e) => {
  const delForm = document.getElementById("delForm");
  delForm.querySelector("input").remove();
  delForm.setAttribute("action", "/board/list");
  delForm.setAttribute("method", "get");
  delForm.submit();
});

document.addEventListener("click", (e) => {
  ("");
});
