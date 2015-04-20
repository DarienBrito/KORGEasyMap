KORGEasyMap {
	var mapper, <>track;

	*new{|mapper|
		^super.new.init(mapper);
	}

	init {|mapper_|
		mapper = mapper_;
		track = false;
	}

	mapKnob {|bus, min, max, curve = \lin|
		case
		{curve == \lin} {^mapper.knobs[bus].ctrl.mappingFunc_({ arg x;
			var val;
			val = x.linlin(0,127,min,max);
			if(track) {val.postln};
			val;
		}).map}
		{curve == \exp} {^mapper.knobs[bus].ctrl.mappingFunc_({ arg x;
			var val;
			val = x.linexp(0,127,min,max);
			if(track) {val.postln};
			val;
		}).map }
	}

	mapSlider {|bus, min, max, curve = \lin|
		case
		{curve == \lin} {^mapper.sliders[bus].ctrl.mappingFunc_({ arg x;
			var val;
			val = x.linlin(0,127,min,max);
			if(track) {val.postln};
			val;
		}).map}
		{curve == \exp} {^mapper.sliders[bus].ctrl.mappingFunc_({ arg x;
			var val;
			val = x.linexp(0,127,min,max);
			if(track) {val.postln};
			val;
		}).map}
	}

	mapButton {|bus, functionOn, functionOff|
		^mapper.buttons[bus].func(functionOn, functionOff);
	}
}
