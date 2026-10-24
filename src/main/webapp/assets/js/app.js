(() => {
  const progress = document.getElementById('progress');
  const updateProgress = () => {
    const max = document.documentElement.scrollHeight - window.innerHeight;
    progress.style.width = (max > 0 ? window.scrollY / max * 100 : 0) + '%';
  };
  window.addEventListener('scroll', updateProgress, { passive: true });
  updateProgress();

  const revealItems = document.querySelectorAll('.reveal');
  if ('IntersectionObserver' in window) {
    const observer = new IntersectionObserver(entries => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          entry.target.classList.add('visible');
          observer.unobserve(entry.target);
        }
      });
    }, { threshold: 0.12 });
    revealItems.forEach(item => observer.observe(item));
  } else revealItems.forEach(item => item.classList.add('visible'));

  const menu = document.getElementById('menu');
  const nav = document.querySelector('.topbar nav');
  menu.addEventListener('click', () => nav.classList.toggle('open'));
  nav.querySelectorAll('a').forEach(link => link.addEventListener('click', () => nav.classList.remove('open')));

  const form = document.getElementById('reserveForm');
  const message = document.getElementById('formMessage');
  form.addEventListener('submit', async event => {
    event.preventDefault();
    message.textContent = 'Sending your request…';
    const body = new URLSearchParams(new FormData(form));
    try {
      const response = await fetch('api/reserve', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' },
        body
      });
      const data = await response.json();
      message.textContent = data.message || 'Something went wrong. Please try again.';
      if (response.ok && data.ok) form.reset();
    } catch (_) {
      message.textContent = 'API unavailable. Check that the app is deployed on Tomcat.';
    }
  });
})();