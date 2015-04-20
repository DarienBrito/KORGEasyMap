# KORGEasyMap
A wrapper for the KORGMapper SuperCollider classes by Adam Jurazek:

// Download the KORGMapper classes first:
https://github.com/Endut/KORGNanoKontrol

// How to use the wrapper:
(
  MIDIdef.freeAll;
	Buffer.freeAll;
	MIDIClient.init;
)

MIDIIn.connectAll;
a = KORGMapper.new(0);
a.setup;
m = KORGEasyMap(a); //<--- The wrapper takes a KORGMapper as argument

// Hook things up:
(
a = Pbind(
	\midinote, m.mapKnob(0,60,120), 
	\amp, m.mapSlider(0, 0.1,1.0)
);
m.mapButton(0,{ a = a.play; "I'm playing".postln},{ a.stop; "I stopped".postln});
)

// Enjoy.



