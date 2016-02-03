        // tes malarkey
        var elem = document.querySelector('#tesMalarkey');
            initialText = elem.textContent;
        var opts = {
          speed: 30,
          loop: true,
          postfix: ''
        };
        var typist= malarkey(elem, opts)
        typist
            .pause(2400).delete(initialText.length)
            .type('N G A P A K E R S - - - P R E S E N T').pause().delete(37)