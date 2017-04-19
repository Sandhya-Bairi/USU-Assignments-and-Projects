%%% =======================================================================
%%% HW08: Harmonic Recovery and Audio Analysis
%%% Author: Anuj Khasgiwala
%%% =======================================================================
function problem_01()
  warning("off", "Octave:broadcast");
  DELTA = (2*pi)/6283;
  threshold = 0.1;
  t = -pi:DELTA:pi;

  %% combined sinusoid
  data = load("D:/workspace/USU-Assignments/CS 6810 - Wavelets and Wavelet Algorithms/Assignment 8/hw08/data.txt");
  data = data'(:)';

  %% plot data
  figure;
  plot(t, data);
  xlabel('x');
  ylabel('y');
  title('Input Data');

  %% ================= Recovering sine Coefficients ======================

  f = 1:150;
  sine_coeffs = [];
  cos_coeffs = [];
  for fi=f
      sine_coeff = 1/pi*sum(data.*sin(fi*t))*DELTA;
      if ( abs(sine_coeff) > threshold )
        disp(strcat(strcat(strcat("a",num2str(fi))," = "), num2str(abs(sine_coeff))));
        sine_coeffs(fi) = abs(sine_coeff);
      else
        sine_coeffs(fi) = 0.0;
      endif
  %% ================= Recovering cosine Coefficients ======================
      cos_coeff = 1/pi*sum(data.*cos(fi*t))*DELTA;
      if ( abs(cos_coeff) > threshold )
        disp(strcat(strcat(strcat("b",num2str(fi))," = "), num2str(abs(cos_coeff))));
        cos_coeffs(fi) = abs(cos_coeff);
      else
        cos_coeffs(fi) = 0.0;
      endif
  end

  %% plot sine coefficients
  figure;
  plot(f, sine_coeffs);
  xlabel('Freq');
  ylabel('Sine Coeff');
  title('Present Sine Coefficients');

  %% plot cosine coefficients
  figure;
  plot(f, cos_coeffs);
  xlabel('Freq');
  ylabel('Cosine Coeff');
  title('Present Cosine Coefficients')

endfunction

function analysis(file, titlen)
  [y, Fs] = audioread(file);
  Nsamps = length(y);
  t = (1/Fs)*(1:Nsamps);
  y_fft = abs(fft(y));
  y_fft = y_fft(1:Nsamps/2);
  f = Fs*(0:Nsamps/2-1)/Nsamps;

  figure;
  plot(f,y_fft);
  xlim([0 1000]);
  xlabel('Frequency(Hz)');
  ylabel('Amplitude');
  title(titlen);
endfunction

function problem_02()
  warning("off", "Octave:broadcast");
  analysis("D:/workspace/USU-Assignments/CS 6810 - Wavelets and Wavelet Algorithms/Assignment 8/hw08/ODE_TO_JOY_RIGHT_HAND.wav", "Right hand");
  disp("Right hand top 5 frequencies");
  disp("330Hz -> E4");
  disp("390Hz -> G4");
  disp("290Hz -> D4");
  disp("585Hz -> D5");
  disp("524Hz -> C5");
  
  analysis("D:/workspace/USU-Assignments/CS 6810 - Wavelets and Wavelet Algorithms/Assignment 8/hw08/ODE_TO_JOY_BOTH_HANDS.wav", "Both hands");
  disp("Both hands top 5 frequencies");
  disp("330Hz -> E4");
  disp("390Hz -> G4");
  disp("293Hz -> D4");
  disp("585Hz -> D5");
  disp("260Hz -> C4");

  analysis("D:/workspace/USU-Assignments/CS 6810 - Wavelets and Wavelet Algorithms/Assignment 8/hw08/ODE_TO_JOY_ORCHESTRA.wav", "Orchestra");
  disp("Orchestra top 5 frequencies");
  disp("1190Hz -> D6");
  disp("1350Hz -> E6");
  disp("775Hz -> G5");
  disp("595Hz -> D5");
  disp("795Hz -> G5");
endfunction