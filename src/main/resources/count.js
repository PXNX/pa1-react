function count1() {
    var count = 0

    setInterval(function () {
        console.log("counting " + count++)
    }, 1000)

}

function count2() {
    var count = 0

    setInterval(function () {
        count = count+2
        console.log("counting " + count)
    }, 1000)

}

self.addEventListener('install', e => {
    console.log("sw install")
    console.log(count2())
});

self.addEventListener('activate', event => {
    console.log("activate wait until …")
    event.waitUntil(self.clients.claim());
});

self.addEventListener('fetch', event => {
    console.log("fetch event")
    console.log(count1())
});