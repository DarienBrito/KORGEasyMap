# KORGEasyMap
A wrapper for the KORGMapper SuperCollider classes by Adam Jurazek

a) Download the forked KORGMapper classes from my repository (It already contains my addition)

or

1) First download the KORGMapper classes from:
https://github.com/Endut/KORGNanoKontrol

2) Download the KORGEasyMap file from this repository

So...  How to use the wrapper:

``` js
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

//Enjoy

```





