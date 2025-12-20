(async () => {
    const CARD_LIMIT = 252; 
    const CLICK_DELAY = 2200; 

    console.log(`🚀 Starting Final Scrape: Target 255 cards.`);

    const deck = new Map();
    window.isFinished = false;

    const downloadCSV = (map) => {
        if (map.size === 0) return;
        let csvContent = "Front,Back\n";
        map.forEach(card => {
            const escape = (text) => {
                if (!text) return '""';
                return `"${text.replace(/"/g, '""').replace(/\n/g, "<br>")}"`;
            };
            csvContent += `${escape(card.front)},${escape(card.back)}\n`;
        });
        const blob = new Blob([csvContent], { type: 'text/csv;charset=utf-8;' });
        const url = URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = `wiley_java_255_cards.csv`;
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
        console.log(`🏁 LOG: Successfully exported ${map.size} unique cards.`);
    };

    const originalFetch = window.fetch;
    window.fetch = async (...args) => {
        const response = await originalFetch(...args);
        if (window.isFinished) return response;

        if (args[0].includes('graphql')) {
            const clone = response.clone();
            clone.json().then(body => {
                const info = body?.data?.getFlashcardInfo;
                if (info && info.frontText) {
                    const cardKey = info.qtiId || info.frontText;
                    
                    // Strict one-log-per-card logic
                    if (!deck.has(cardKey) && deck.size < CARD_LIMIT) {
                        deck.set(cardKey, {
                            front: info.frontText,
                            back: info.backText
                        });
                        
                        console.log(`📥 [Card ${deck.size}/${CARD_LIMIT}] Captured: ${info.frontText.substring(0, 40)}...`);
                        
                        if (deck.size === CARD_LIMIT) {
                            window.isFinished = true;
                            downloadCSV(deck);
                        }
                    }
                }
            }).catch(() => {});
        }
        return response;
    };

    try {
        while (deck.size < CARD_LIMIT && !window.isFinished) {
            const btn = document.getElementById('primaryBtn-Flashcard');
            if (btn) {
                btn.click();
            } else {
                console.log("🏁 LOG: Button 'primaryBtn-Flashcard' no longer available. Finalizing...");
                break;
            }
            await new Promise(r => setTimeout(r, CLICK_DELAY));
        }
    } catch (e) {
        console.error("⚠️ LOG: Script encountered an error during loop:", e);
    } finally {
        if (!window.isFinished) {
            window.isFinished = true;
            downloadCSV(deck);
        }
    }
})();